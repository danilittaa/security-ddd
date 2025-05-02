package com.todoriak.securityddd;


/*
    @author danatodoriak
    @project security-ddd
    @class AccessTests
    @version 1.0.0
    @since 02.05.2025 - 10.36
*/

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccessTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeAll
    void beforeAll() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithAnonymousUser
    public void whenAnonymThenStatusUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessesAdminEndpointThenSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels/hello-admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessesUserEndpointThenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels/hello-user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessesUserEndpointThenSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels/hello-user"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessesAdminEndpointThenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels/hello-admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessesUnknownEndpointThenSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels/hello-unknown"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessesUnknownEndpointThenSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels/hello-unknown"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void whenAnonymousAccessesStrangerEndpointThenUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels/hello-stranger"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminRequestsSpecificCatHotelThenSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/catHotels/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserUsesDeleteMethodThenForbidden() throws Exception {
        mockMvc.perform(delete("/api/v1/catHotels/1"))
                .andExpect(status().isForbidden());
    }
}
