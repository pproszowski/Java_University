public class Company extends Record{
    String name;
    String address;

    Company(String _name, String _address, PhoneNumber _phoneNumber){
        super(_phoneNumber);
        name = _name;
        address = _address;
    }

    @Override
    String getDescription(){
        return "Company: " + name + ", " + address + ", " + super.getPhoneNumber();
    }
}
