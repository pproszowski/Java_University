public class Person extends Record{
    String firstName;
    String surname;
    String address;

    Person(String _firstName, String _surname, String _address, PhoneNumber _phoneNumber){
        super(_phoneNumber);
        firstName = _firstName;
        surname = _surname;
        address = _address;
    }

    @Override
    String getDescription(){
        return "Person: " + surname + " " + firstName + ", " + address + ", " + super.getPhoneNumber();
    }
}
