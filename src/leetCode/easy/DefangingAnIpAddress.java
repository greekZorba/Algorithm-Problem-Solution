package leetCode.easy;

public class DefangingAnIpAddress {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        DefangingAnIpAddress defangingAnIpAddress = new DefangingAnIpAddress();
        String input = "1.1.1.1";
        System.out.println(defangingAnIpAddress.defangIPaddr(input));
    }
}
