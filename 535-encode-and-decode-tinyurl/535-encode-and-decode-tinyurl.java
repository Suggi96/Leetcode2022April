public class Codec {
    HashMap<String, String> map = new HashMap<>();
    int count = 0;
    String prefix = "https://leetcode.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // String key = prefix + count;
        // count++;
        // map.put(key, longUrl);
        // return key;
        StringBuilder key = new StringBuilder();
        key.append(prefix);
        key.append(String.valueOf(count));
        count++;
        map.put(key.toString(), longUrl);
        return key.toString();
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // String key = prefix + (count-1);
        // return map.get(key);
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));