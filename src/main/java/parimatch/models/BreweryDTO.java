package parimatch.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class BreweryDTO extends BaseDTO {
    private Integer id;
    private String name;
    @JsonProperty("brewery_type")
    private String breweryType;
    private String street;
    @JsonProperty("address_2")
    private String address2;
    @JsonProperty("address_3")
    private String address3;
    private String city;
    private String state;
    @JsonProperty("county_province")
    private String countyProvince;
    @JsonProperty("postal_code")
    private String postalCode;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;
    @JsonProperty("website_url")
    private String websiteUrl;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("created_at")
    private String createdAt;

    public boolean containsQuery(String query) {
        return fieldContainsQuery(name, query) ||
                fieldContainsQuery(street, query) ||
                fieldContainsQuery(address2, query) ||
                fieldContainsQuery(address3, query) ||
                fieldContainsQuery(city, query) ||
                fieldContainsQuery(state, query) ||
                fieldContainsQuery(countyProvince, query) ||
                fieldContainsQuery(country, query) ||
                fieldContainsQuery(websiteUrl, query);
    }

    private boolean fieldContainsQuery(String field, String query) {
        return null != field && field.toLowerCase().contains(query);
    }
}
