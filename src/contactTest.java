public class contactTest {
        public static void main(String[] args) {

            contact Billy = new contact("Billy", "1234567");
            contactApplication cm = new contactApplication();

            cm.contactList.add(Billy);
            cm.showAll(cm.contactList);

            cm.writeContactToFile("contact.txt", cm.contactList);



        }
    }

