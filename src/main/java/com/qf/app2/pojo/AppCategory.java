package com.qf.app2.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "app_category")
public class AppCategory  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "parent_id")
	private Integer parentId;

	@Column(name = "is_parent")
	private String isParent;

	private java.util.Date created;

	private java.util.Date updated;

}
