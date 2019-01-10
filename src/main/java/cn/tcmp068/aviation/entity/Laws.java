package cn.tcmp068.aviation.entity;

public class Laws {
    private Integer lawsid;

    private Integer lawspart;

    private Integer lawsversion;

    private String lawsname;

    private Integer lawslogo;

    private String lawsdownload;

    private String lawsstate;

    public Integer getLawsid() {
        return lawsid;
    }

    public void setLawsid(Integer lawsid) {
        this.lawsid = lawsid;
    }

    public Integer getLawspart() {
        return lawspart;
    }

    public void setLawspart(Integer lawspart) {
        this.lawspart = lawspart;
    }

    public Integer getLawsversion() {
        return lawsversion;
    }

    public void setLawsversion(Integer lawsversion) {
        this.lawsversion = lawsversion;
    }

    public String getLawsname() {
        return lawsname;
    }

    public void setLawsname(String lawsname) {
        this.lawsname = lawsname == null ? null : lawsname.trim();
    }

    public Integer getLawslogo() {
        return lawslogo;
    }

    public void setLawslogo(Integer lawslogo) {
        this.lawslogo = lawslogo;
    }

    public String getLawsdownload() {
        return lawsdownload;
    }

    public void setLawsdownload(String lawsdownload) {
        this.lawsdownload = lawsdownload == null ? null : lawsdownload.trim();
    }

    public String getLawsstate() {
        return lawsstate;
    }

    public void setLawsstate(String lawsstate) {
        this.lawsstate = lawsstate == null ? null : lawsstate.trim();
    }
}