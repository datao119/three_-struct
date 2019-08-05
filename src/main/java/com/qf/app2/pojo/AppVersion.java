package com.qf.app2.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "app_version")
public class AppVersion  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "app_id")
	private Integer appId;

	@Column(name = "version_no")
	private String versionNo;

	@Column(name = "version_info")
	private String versionInfo;

	@Column(name = "publish_status")
	private Integer publishStatus;

	@Column(name = "download_link")
	private String downloadLink;

	@Column(name = "version_size")
	private String versionSize;

	@Column(name = "apk_file_name")
	private String apkFileName;

	private java.util.Date created;

	private java.util.Date updated;

}
