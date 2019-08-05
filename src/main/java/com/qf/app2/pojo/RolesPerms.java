package com.qf.app2.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "roles_perms")
public class RolesPerms  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "perm_name")
	private String permName;

	private java.util.Date created;

	private java.util.Date updated;

	@Column(name = "role_id")
	private Integer roleId;

}
