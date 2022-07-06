package org.camping.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class EquipDTO {
	private int num;
	private String title;
	private int price;
	private double score;
	private int review ;
	private String content;
	private String image;
	private String url_name;
	private String manual ;
	private int category;
	private String brand;
	private String fil1;
	private String fil2;
	private String fil3;
	private String fil4;
	private String fil5;
    private int status;
    private int tent_count;
    private int taf_count;
    private int mat_count;
    private int sb_count;
    private int chair_count;
    private int ib_count;
    private int cw_count;
    private int stove_count;
    private int gas_count;
    private int light_count;
    

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reg;
	
}

