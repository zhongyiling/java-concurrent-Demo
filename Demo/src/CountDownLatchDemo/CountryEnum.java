package CountDownLatchDemo;

public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");
    private Integer retCode;
    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] countryList = CountryEnum.values();
        for (CountryEnum element:countryList) {
            if(index == element.getRetCode()){
                return  element;
            }
        }
        return null;
    }

}
