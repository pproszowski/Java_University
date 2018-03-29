public class PhoneNumber implements Comparable<PhoneNumber>{
    private String areaCode;
    private String phoneNumber;


    PhoneNumber(String _areaCode, String _phoneNumber){
        areaCode = _areaCode;
        phoneNumber = _phoneNumber;
    }

    public String getAreaCode(){
        return areaCode;
    }

    public String getNumber(){
        return phoneNumber;
    }

    @Override
    public String toString(){
        return "+" + areaCode + " " + phoneNumber;
    }

    @Override
    public int compareTo(PhoneNumber number){
        int last = areaCode.compareTo(number.getAreaCode());
        return last == 0 ? phoneNumber.compareTo(number.getNumber()) : last;
    }
}
