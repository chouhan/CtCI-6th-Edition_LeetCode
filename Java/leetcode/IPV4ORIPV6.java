public class IPV4ORIPV6 {
    public String validIPAddress(String IP) {
        if(IP.equals("")) return "Neither";
        if(isValidIPv4(IP)) return "IPv4";
        if(isValidIPv6(IP)) return "IPv6";
        return "Neither";
    }

    public boolean isValidIPv4(String ip) {
        if(ip.length()<7) return false;
        if(ip.charAt(0)=='.') return false;
        if(ip.charAt(ip.length()-1)=='.') return false;
        String[] tokens = ip.split("\\.");
        if(tokens.length!=4) return false;
        for(String token:tokens) {
            if(!isValidIPv4Token(token)) return false;
        }
        return true;
    }
    public boolean isValidIPv4Token(String token) {
        if(token.startsWith("0") && token.length()>1) return false;
        try {
            int parsedInt = Integer.parseInt(token);
            if(parsedInt<0 || parsedInt>255) return false;
            if(parsedInt==0 && token.charAt(0)!='0') return false;
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isValidIPv6(String ip) {
        if(ip.length()<15) return false;
        if(ip.charAt(0)==':') return false;
        if(ip.charAt(ip.length()-1)==':') return false;
        String[] tokens = ip.split(":");
        if(tokens.length!=8) return false;
        for(String token: tokens) {
            if(!isValidIPv6Token(token)) return false;
        }
        return true;
    }
    public boolean isValidIPv6Token(String token) {
        if(token.length()>4 || token.length()==0) return false;
        char[] chars = token.toCharArray();
        for(char c:chars) {
            boolean isDigit = c>=48 && c<=57;
            boolean isUppercaseAF = c>=65 && c<=70;
            boolean isLowerCaseAF = c>=97 && c<=102;
            if(!(isDigit || isUppercaseAF || isLowerCaseAF))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        IPV4ORIPV6 ipv4ORIPV6 = new IPV4ORIPV6();
        System.out.println("Is this 192.168.231.1 ipv4 or ipv6? " + ipv4ORIPV6.validIPAddress("192.168.231.1"));
        System.out.println("Is this fe80::ec00:76f4:e249:f778%7 ipv4 or ipv6? " + ipv4ORIPV6.validIPAddress("fe80::ec00:76f4:e249:f778%7"));
    }
}
