package com.qf.app2.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "app_info")
public class AppInfo  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "software_name")
	private String softwareName;

	@Column(name = "apk_name")
	private String apkName;

	@Column(name = "support_rom")
	private String supportRom;

	@Column(name = "interface_language")
	private String interfaceLanguage;

	@Column(name = "software_size")
	private String softwareSize;

	@Column(name = "app_info")
	private String appInfo;

	@Column(name = "app_status")
	private Integer appStatus;

	@Column(name = "on_sale_date")
	private java.util.Date onSaleDate;

	@Column(name = "off_sale_date")
	private java.util.Date offSaleDate;

	@Column(name = "flatform_id")
	private Integer flatformId;

	private Integer downloads;

	@Column(name = "category_level1")
	private Integer categoryLevel1;

	@Column(name = "category_level2")
	private Integer categoryLevel2;

	@Column(name = "category_level3")
	private Integer categoryLevel3;

	@Column(name = "dev_id")
	private Integer devId;

	@Column(name = "pic_path")
	private String picPath;

	@Column(name = "version_id")
	private Integer versionId;

	private java.util.Date created;

	private java.util.Date updated;

}
