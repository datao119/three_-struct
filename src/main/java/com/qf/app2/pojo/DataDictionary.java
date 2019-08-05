package com.qf.app2.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "data_dictionary")
public class DataDictionary  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "type_code")
	private String typeCode;

	@Column(name = "type_name")
	private String typeName;

	@Column(name = "value_id")
	private Integer valueId;

	@Column(name = "value_name")
	private String valueName;

	private java.util.Date created;

	private java.util.Date updated;

}
