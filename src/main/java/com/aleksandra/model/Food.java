package com.aleksandra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "food")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;
	
	@Column(name = "food_name")
	private String name;
	
	@Transient
	private static final String amountPer = "100g";
	
	@Column(name = "food_unit")
	private String unit;
	
	@Column(name = "food_price")
	private Double price;
	
	@Column(name = "food_calories")
	private Double calories;
	
	@Column(name = "food_total_fat")
	private Double totalFat;
	
	@Column(name = "food_cholesterol")
	private Double cholesterol;
	
	@Column(name = "food_sodium")
	private Double sodium;
	
	@Column(name = "food_potassium")
	private Double potassium;
	
	@Column(name = "food_total_carbohydrate")
	private Double totalCarbohydrate;
	
	@Column(name = "food_protein")
	private Double protein;
	
	@Column(name = "food_calcium")
	private Double calcium;
	
	@Column(name = "food_iron")
	private Double iron;
	
	@Column(name = "food_magnesium")
	private Double magnesium;
	
	@Column(name = "food_vitaminA")
	private Double vitaminA;
	
	@Column(name = "food_vitaminB6")
	private Double vitaminB6;
	
	@Column(name = "food_vitaminB12")
	private Double vitaminB12;
	
	@Column(name = "food_vitaminC")
	private Double vitaminC;
	
	@Column(name = "food_vitaminD")
	private Double vitaminD;

	@ManyToOne
	@JoinColumn(name = "food_type_id")
	private FoodType foodType;
	
	public Food() {
	
	}

	public Food(String name, Double calories, Double totalFat, Double cholesterol, Double sodium, Double potassium,
			Double totalCarbohydrate, Double protein, Double calcium, Double iron, Double magnesium, Double vitaminA,
			Double vitaminB6, Double vitaminB12, Double vitaminC, Double vitaminD) {
		super();
		this.name = name;
		this.calories = calories;
		this.totalFat = totalFat;
		this.cholesterol = cholesterol;
		this.sodium = sodium;
		this.potassium = potassium;
		this.totalCarbohydrate = totalCarbohydrate;
		this.protein = protein;
		this.calcium = calcium;
		this.iron = iron;
		this.magnesium = magnesium;
		this.vitaminA = vitaminA;
		this.vitaminB6 = vitaminB6;
		this.vitaminB12 = vitaminB12;
		this.vitaminC = vitaminC;
		this.vitaminD = vitaminD;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	public Double getTotalFat() {
		return totalFat;
	}

	public void setTotalFat(Double totalFat) {
		this.totalFat = totalFat;
	}

	public Double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(Double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public Double getSodium() {
		return sodium;
	}

	public void setSodium(Double sodium) {
		this.sodium = sodium;
	}

	public Double getPotassium() {
		return potassium;
	}

	public void setPotassium(Double potassium) {
		this.potassium = potassium;
	}

	public Double getTotalCarbohydrate() {
		return totalCarbohydrate;
	}

	public void setTotalCarbohydrate(Double totalCarbohydrate) {
		this.totalCarbohydrate = totalCarbohydrate;
	}

	public Double getProtein() {
		return protein;
	}

	public void setProtein(Double protein) {
		this.protein = protein;
	}

	public Double getCalcium() {
		return calcium;
	}

	public void setCalcium(Double calcium) {
		this.calcium = calcium;
	}

	public Double getIron() {
		return iron;
	}

	public void setIron(Double iron) {
		this.iron = iron;
	}

	public Double getMagnesium() {
		return magnesium;
	}

	public void setMagnesium(Double magnesium) {
		this.magnesium = magnesium;
	}

	public Double getVitaminA() {
		return vitaminA;
	}

	public void setVitaminA(Double vitaminA) {
		this.vitaminA = vitaminA;
	}

	public Double getVitaminB6() {
		return vitaminB6;
	}

	public void setVitaminB6(Double vitaminB6) {
		this.vitaminB6 = vitaminB6;
	}

	public Double getVitaminB12() {
		return vitaminB12;
	}

	public void setVitaminB12(Double vitaminB12) {
		this.vitaminB12 = vitaminB12;
	}

	public Double getVitaminC() {
		return vitaminC;
	}

	public void setVitaminC(Double vitaminC) {
		this.vitaminC = vitaminC;
	}

	public Double getVitaminD() {
		return vitaminD;
	}

	public void setVitaminD(Double vitaminD) {
		this.vitaminD = vitaminD;
	}

	public static String getAmountper() {
		return amountPer;
	}

	public FoodType getFoodType() {
		return foodType;
	}  
	
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", calories=" + calories + ", totalFat=" + totalFat
				+ ", cholesterol=" + cholesterol + ", sodium=" + sodium + ", potassium=" + potassium
				+ ", totalCarbohydrate=" + totalCarbohydrate + ", protein=" + protein + ", calcium=" + calcium
				+ ", iron=" + iron + ", magnesium=" + magnesium + ", vitaminA=" + vitaminA + ", vitaminB6=" + vitaminB6
				+ ", vitaminB12=" + vitaminB12 + ", vitaminC=" + vitaminC + ", vitaminD=" + vitaminD + "]";
	}
}
