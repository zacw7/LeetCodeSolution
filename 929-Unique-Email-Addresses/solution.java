class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet();
        for (String email : emails) {
            String[] subStrs = email.split("@", 2);
            String localName = subStrs[0], domainName = subStrs[1];
            localName = localName.replaceAll("\\.", "");  // remove all '.'
            localName = localName.split("\\+", 2)[0];  // remove substring after '+'
            StringBuilder sb = new StringBuilder();
            sb.append(localName).append(domainName);
            emailSet.add(sb.toString());
        }
        return emailSet.size();
    }
}