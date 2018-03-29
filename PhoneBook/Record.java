public abstract class Record{
    private PhoneNumber phoneNumber;
    abstract String getDescription();

    protected Record(PhoneNumber _phoneNumber){
        phoneNumber = _phoneNumber;
    }
    public PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }
}
