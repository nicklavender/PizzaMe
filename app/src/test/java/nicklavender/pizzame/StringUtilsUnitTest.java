/*
 * Created by Nick Lavender - 2018
 */
package nicklavender.pizzame;

import org.junit.Test;

import nicklavender.pizzame.utils.StringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StringUtilsUnitTest {

    @Test
    public void test_get_default_api() {
        assertEquals("yql?q=select%20*%20from%20local.search%20where%20zip%3D%2778758%27%20and%20query%3D%27pizza%27&format=json&diagnostics=false&callback=", StringUtils.getDefaultApi("78758"));
    }

    @Test
    public void test_get_paged_api() {
        assertEquals("yql?q=select%20*%20from%20local.search%2810%2C10%29%20where%20zip%3D%2778758%27%20and%20query%3D%27pizza%27&format=json&diagnostics=false&callback=", StringUtils.getPagedApi("78758", 10, 10));
    }

    @Test
    public void test_get_title() {
        assertEquals("Pizza Test Restaurant", StringUtils.getTitle("Pizza Test Restaurant"));
        assertEquals("", StringUtils.getTitle(""));
    }

    @Test
    public void test_get_rating() {
        assertEquals("3 stars", StringUtils.getRating("3"));
        assertEquals("No rating available", StringUtils.getRating("NaN"));
    }

    @Test
    public void test_get_city_state() {
        assertEquals("Austin, Texas", StringUtils.getCityState("Austin", "Texas"));
        assertEquals("Texas", StringUtils.getCityState("", "Texas"));
        assertEquals("Austin", StringUtils.getCityState("Austin", ""));
        assertEquals("Texas", StringUtils.getCityState(null, "Texas"));
        assertEquals("Austin", StringUtils.getCityState("Austin", null));
        assertEquals("", StringUtils.getCityState("", ""));
        assertEquals("", StringUtils.getCityState(null, null));
    }

    @Test
    public void test_get_distance() {
        assertEquals("3mi.", StringUtils.getDistance("3"));
        assertEquals("", StringUtils.getDistance(""));
        assertEquals("", StringUtils.getDistance(null));
    }

    @Test
    public void test_get_total_ratings() {
        assertEquals("20 ratings", StringUtils.getTotalRatings("20"));
        assertEquals("", StringUtils.getTotalRatings(""));
        assertEquals("", StringUtils.getTotalRatings(null));
    }

    @Test
    public void test_get_geo_search_string() {
        assertEquals("geo:20,20?q=", StringUtils.getGeoSearchString("20", "20"));
    }

    @Test
    public void test_is_null_or_empty() {
        assertFalse(StringUtils.isNullOrEmpty("a"));
        assertTrue(StringUtils.isNullOrEmpty(""));
        assertTrue(StringUtils.isNullOrEmpty(null));
    }

}
