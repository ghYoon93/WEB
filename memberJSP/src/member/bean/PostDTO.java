package member.bean;

public class PostDTO {
    private String zipcode;
    private String sido;
    private String sigungu;
    private String yubmyundong;
    private String ri;
    private String roadname;
    private String buildingname;
    
    public PostDTO() {
        
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public void setSigungu(String sigungu) {
        this.sigungu = sigungu;
    }

    public void setYubmyundong(String yubmyundong) {
        this.yubmyundong = yubmyundong;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public void setRoadname(String roadname) {
        this.roadname = roadname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getSido() {
        return sido;
    }

    public String getSigungu() {
        return sigungu;
    }

    public String getYubmyundong() {
        return yubmyundong;
    }

    public String getRi() {
        return ri;
    }

    public String getRoadname() {
        return roadname;
    }

    public String getBuildingname() {
        return buildingname;
    }
    
}
