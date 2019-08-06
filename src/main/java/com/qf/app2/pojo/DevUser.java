package com.qf.app2.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dev_user")
public class DevUser  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "dev_username")
	@NotBlank(message = "用户名不能为空")
	private String devUsername;

	@Column(name = "dev_password")
	@NotBlank(message = "用户名不能为空")
	private String devPassword;

	@Column(name = "dev_salt")
	private String devSalt;

	@Column(name = "dev_email")
	private String devEmail;

	@Column(name = "dev_code")
	private String devCode;

	@Column(name = "dev_birthday")
	@NotNull(message = "不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date devBirthday;

	@Column(name = "dev_state")
	private Integer devState;

	private java.util.Date created;

	private java.util.Date updated;

}
