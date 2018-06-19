package tikape.runko.domain;

public class AnnosRaakaAine {

    private Integer raakaaine_id;
    private Integer annos_id;
    private String jarjestys;
    private String maara;
    private String ohje;

    public AnnosRaakaAine(Integer raakaaine_id, Integer annos_id, String jarjestys,String maara, String ohje) 
    {
        this.raakaaine_id = raakaaine_id;
        this.annos_id = annos_id;
        this.jarjestys = jarjestys;
        this.maara= maara;
        this.ohje = ohje;
    }

    public Integer getRaakaaine_Id() {
        return raakaaine_id;
    }

    public Integer getAnnos_Id() {
        return annos_id;
    }

    public String getJarjestys() {
        return jarjestys;
    }

    public String getMaara() {
        return maara;
    }

    public String getOhje() {
        return ohje;
    }
    
}
