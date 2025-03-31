package com.todoriak.securityddd.staffMember;


/*
    @author danatodoriak
    @project security-ddd
    @class StaffMember
    @version 1.0.0
    @since 31.03.2025 - 15.30
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffMember {
    @Id
    private String id;
    private String name;
    private Role role;
}
