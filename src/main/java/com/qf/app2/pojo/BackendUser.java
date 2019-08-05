package com.qf.app2.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "backend_user")
public class BackendUser  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "backend_code")
	private String backendCode;

	@Column(name = "backend_password")
	private String backendPassword;

	@Column(name = "backend_salt")
	private String backendSalt;

	@Column(name = "backend_name")
	private String backendName;

	@Column(name = "backend_type")
	private Integer backendType;

	private java.util.Date created;

	private java.util.Date updated;

}
