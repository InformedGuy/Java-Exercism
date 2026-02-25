import java.util.HashMap;
import java.util.Map;

public class DialingCodes {

    private Map<Integer, String> countryDialingCodes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return countryDialingCodes;
    }

    public void setDialingCode(Integer code, String country) {
        countryDialingCodes.put(code, country);
    }

    public String getCountry(Integer code) {
        return countryDialingCodes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!countryDialingCodes.containsValue(country)) {
            countryDialingCodes.putIfAbsent(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        for (Map.Entry<Integer, String> entry : countryDialingCodes.entrySet()) {
            if (entry.getValue().equals(country)) {
                return entry.getKey();
            }
        }

        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer codeToRemove = findDialingCode(country);
        if (codeToRemove != null) {
            countryDialingCodes.remove(codeToRemove);
            countryDialingCodes.put(code, country);
        }
    }
}
