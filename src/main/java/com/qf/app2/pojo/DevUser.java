package com.qf.app2.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dev_user")
public class DevUser  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "dev_username")
	private String devUsername;

	@Column(name = "dev_password")
	private String devPassword;

	@Column(name = "dev_salt")
	private String devSalt;

	@Column(name = "dev_email")
	private String devEmail;

	@Column(name = "dev_code")
	private String devCode;

	@Column(name = "dev_birthday")
	private java.util.Date devBirthday;

	@Column(name = "dev_state")
	private Integer devState;

	private java.util.Date created;

	private java.util.Date updated;

}
