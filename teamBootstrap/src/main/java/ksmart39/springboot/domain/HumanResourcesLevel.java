package ksmart39.springboot.domain;

public class HumanResourcesLevel {
	private String levelNum;
	private String levelName;
	
	public String getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(String levelNum) {
		this.levelNum = levelNum;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	@Override
	public String toString() {
		return "HumanResourcesLevel [levelNum=" + levelNum + ", levelName=" + levelName + "]";
	}
	
	
}
