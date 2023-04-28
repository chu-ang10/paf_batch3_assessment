package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {
    public static final String GET_LANDING_PAGE = "SELECT style.style_name as Style, COUNT(*) as Beer_Count FROM beers join styles on styles.id = beers.style_id GROUP BY beers.style_id ORDER BY Beer_Count, style.style_name(ASC)";

    public static final String GET_BEER_DESCRIPT = "SELECT beers.name as beer_name, beers.descript as beers_descript, breweries.name as brewery_name FROM beers join breweries on beers.brewery_id = breweries.id ORDER BY beers.name(ASC)";

    public static final String GET_BEER_FROM_BREWERY = "SELECT breweries.name as brewery_name, breweries.descript as breweries_descript, breweries.address1 as breweries_address1, breweries.address2 as breweries_address2, breweries.city as breweries_city, breweries.phone as breweries_phone, breweries.website as breweries_website, beers.name as beers_name, beers.descript as beers_descript FROM beers join breweries on beers.brewery_id = breweries.id";
}

