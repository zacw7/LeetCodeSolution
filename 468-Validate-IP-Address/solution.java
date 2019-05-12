class Solution {
    public String validIPAddress(String IP) {
        if (IP.indexOf(".") >= 0) {
            if (IP.indexOf(":") == -1 && validIPv4Address(IP)) {
                return "IPv4";
            }
        } else if (IP.indexOf(":") >= 0) {
            if (validIPv6Address(IP)) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    private boolean validIPv4Address(String IP) {
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] segments = IP.split("\\.");
        if (segments.length != 4) {
            return false;
        }
        for (String seg : segments) {
            try {
                int num = Integer.valueOf(seg);
                if (num < 0 || num > 255 || String.valueOf(num).length() < seg.length()) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean validIPv6Address(String IP) {
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':' || IP.indexOf("::") >= 0) {
            return false;
        }
        String[] segments = IP.split(":");
        if (segments.length != 8) {
            return false;
        }
        for (String seg : segments) {
            if (seg.length() > 4) {
                return false;
            }
            seg = seg.toLowerCase();
            for (char c : seg.toCharArray()) {
                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}