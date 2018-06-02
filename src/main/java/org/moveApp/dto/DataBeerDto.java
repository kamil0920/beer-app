
package org.moveApp.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "id",
    "name",
    "tagline",
    "first_brewed",
    "description",
    "image_url",
    "abv",
    "ibu",
    "target_fg",
    "target_og",
    "ebc",
    "srm",
    "ph",
    "attenuation_level",
    "volume",
    "boil_volume",
    "method",
    "ingredients",
    "food_pairing",
    "brewers_tips",
    "contributed_by"
})
public class DataBeerDto {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("first_brewed")
    private String firstBrewed;
    @JsonProperty("description")
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("abv")
    private Float abv;
    @JsonProperty("ibu")
    private Float ibu;
    @JsonProperty("target_fg")
    private Float targetFg;
    @JsonProperty("target_og")
    private Float targetOg;
    @JsonProperty("ebc")
    private Float ebc;
    @JsonProperty("srm")
    private Float srm;
    @JsonProperty("ph")
    private Float ph;
    @JsonProperty("attenuation_level")
    private Float attenuationLevel;
    @JsonProperty("volume")
    private Volume volume;
    @JsonProperty("boil_volume")
    private BoilVolume boilVolume;
    @JsonProperty("method")
    private Method method;
    @JsonProperty("ingredients")
    private Ingredients ingredients;
    @JsonProperty("food_pairing")
    private List<String> foodPairing = null;
    @JsonProperty("brewers_tips")
    private String brewersTips;
    @JsonProperty("contributed_by")
    private String contributedBy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("tagline")
    public String getTagline() {
        return tagline;
    }

    @JsonProperty("tagline")
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @JsonProperty("first_brewed")
    public String getFirstBrewed() {
        return firstBrewed;
    }

    @JsonProperty("first_brewed")
    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("abv")
    public Float getAbv() {
        return abv;
    }

    @JsonProperty("abv")
    public void setAbv(Float abv) {
        this.abv = abv;
    }

    @JsonProperty("ibu")
    public Float getIbu() {
        return ibu;
    }

    @JsonProperty("ibu")
    public void setIbu(Float ibu) {
        this.ibu = ibu;
    }

    @JsonProperty("target_fg")
    public Float getTargetFg() {
        return targetFg;
    }

    @JsonProperty("target_fg")
    public void setTargetFg(Float targetFg) {
        this.targetFg = targetFg;
    }

    @JsonProperty("target_og")
    public Float getTargetOg() {
        return targetOg;
    }

    @JsonProperty("target_og")
    public void setTargetOg(Float targetOg) {
        this.targetOg = targetOg;
    }

    @JsonProperty("ebc")
    public Float getEbc() {
        return ebc;
    }

    @JsonProperty("ebc")
    public void setEbc(Float ebc) {
        this.ebc = ebc;
    }

    @JsonProperty("srm")
    public Float getSrm() {
        return srm;
    }

    @JsonProperty("srm")
    public void setSrm(Float srm) {
        this.srm = srm;
    }

    @JsonProperty("ph")
    public Float getPh() {
        return ph;
    }

    @JsonProperty("ph")
    public void setPh(Float ph) {
        this.ph = ph;
    }

    @JsonProperty("attenuation_level")
    public Float getAttenuationLevel() {
        return attenuationLevel;
    }

    @JsonProperty("attenuation_level")
    public void setAttenuationLevel(Float attenuationLevel) {
        this.attenuationLevel = attenuationLevel;
    }

    @JsonProperty("volume")
    public Volume getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    @JsonProperty("boil_volume")
    public BoilVolume getBoilVolume() {
        return boilVolume;
    }

    @JsonProperty("boil_volume")
    public void setBoilVolume(BoilVolume boilVolume) {
        this.boilVolume = boilVolume;
    }

    @JsonProperty("method")
    public Method getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(Method method) {
        this.method = method;
    }

    @JsonProperty("ingredients")
    public Ingredients getIngredients() {
        return ingredients;
    }

    @JsonProperty("ingredients")
    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    @JsonProperty("food_pairing")
    public List<String> getFoodPairing() {
        return foodPairing;
    }

    @JsonProperty("food_pairing")
    public void setFoodPairing(List<String> foodPairing) {
        this.foodPairing = foodPairing;
    }

    @JsonProperty("brewers_tips")
    public String getBrewersTips() {
        return brewersTips;
    }

    @JsonProperty("brewers_tips")
    public void setBrewersTips(String brewersTips) {
        this.brewersTips = brewersTips;
    }

    @JsonProperty("contributed_by")
    public String getContributedBy() {
        return contributedBy;
    }

    @JsonProperty("contributed_by")
    public void setContributedBy(String contributedBy) {
        this.contributedBy = contributedBy;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
