package ibf2022.assessment.paf.batch3.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;

import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;
//import ibf2022.assessment.paf.batch3.models.Style;

@Repository
public class BeerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2

		List<Style> beer_styles = new ArrayList<Style>();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_LANDING_PAGE);
		while (rs.next()) {
			beer_styles.add(Style.create(rs));
		}

		return beer_styles;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(/* You can add any number parameters here */) {
		// TODO: Task 3

		List<Beer> beer_descript = new ArrayList<Beer>();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BEER_DESCRIPT);
		while (rs.next()) {
			beer_descript.add(Beer.create(rs));
		}

		return beer_descript;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery() {
		// TODO: Task 4

		Brewery brewery = new Brewery();
		List<Beer> beers = new ArrayList();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BEER_FROM_BREWERY);

		while(rs.next()){
			if(brewery.getName() == null){
				brewery.setBreweryId(rs.getInt("brewery_id"));
				brewery.setAddress1(rs.getString("breweries_address1"));
				brewery.setAddress2(rs.getString("breweries_address2"));
				brewery.setCity(rs.getString("breweries_city"));
				brewery.setPhone(rs.getString("breweries_phone"));
				brewery.setWebsite(rs.getString("breweries_website"));
				brewery.setDescription(rs.getString("beers_descript"));

				Beer beer = new Beer();
				beer.setBeerName(rs.getString("beer_name"));
				beer.setBeerDescription("beer_description");
				beers.add(beer);

			}
		brewery.setBeers(beers);
		return Optional.ofNullable(brewery);
		}

		return Optional.empty();

    }
}
