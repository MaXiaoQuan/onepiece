package priv.mq.onePiece.entities;

public class Figure {

	//��Ҫ����һ��id���͵����ԣ���Ϊ�������
	private Integer id;
	private String name;
	private Integer age;
	private String characteristic;
	private String hobby;
	private boolean useWeapon;
	private String weapon;
	private String photoPath;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public boolean isUseWeapon() {
		return useWeapon;
	}
	public void setUseWeapon(boolean useWeapon) {
		this.useWeapon = useWeapon;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Figure() {
	}
	
	public Figure(String name, Integer age, String characteristic, String hobby, boolean useWeapon, String weapon,
			String photoPath, String description) {
		super();
		this.name = name;
		this.age = age;
		this.characteristic = characteristic;
		this.hobby = hobby;
		this.useWeapon = useWeapon;
		this.weapon = weapon;
		this.photoPath = photoPath;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Figure [name=" + name + ", age=" + age + ", characteristic=" + characteristic + ", hobby=" + hobby
				+ ", useWeapon=" + useWeapon + ", weapon=" + weapon + ", photoPath=" + photoPath + ", description="
				+ description + "]";
	}

}
