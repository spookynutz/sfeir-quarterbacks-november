package com.sfeir.quarterbacks.textblocks;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBlocksTest {

    @Test
    void html_text_blocks_should_now_be_a_lot_more_readable(){
        // Given
        String newTextBlockVersion = """
                <html>
                    <body>
                        <p>Welcome to SFEIR Quarterbacks</p>
                    </body>
                </html>
                """;

        String oldTextBlock =
                "<html>\n" +
                "    <body>\n" +
                "        <p>Welcome to SFEIR Quarterbacks</p>\n" +
                "    </body>\n" +
                "</html>\n";

        // When
        boolean actual = oldTextBlock.equals(newTextBlockVersion);

        // Then
        assertThat(actual).isTrue();
    }

    @Test
    void sql_text_blocks_should_now_be_a_lot_more_readable(){
        // Given
        String newTextBlockVersion = """
                    SELECT
                        country.country_name_eng,
                        SUM(CASE WHEN call.id IS NOT NULL THEN 1 ELSE 0 END) AS calls,
                        AVG(ISNULL(DATEDIFF(SECOND, call.start_time, call.end_time),0)) AS avg_difference
                    FROM country
                    LEFT JOIN city ON city.country_id = country.id
                    LEFT JOIN customer ON city.id = customer.city_id
                    LEFT JOIN call ON call.customer_id = customer.id
                    GROUP BY
                        country.id,
                        country.country_name_eng
                    HAVING AVG(ISNULL(DATEDIFF(SECOND, call.start_time, call.end_time),0)) > (SELECT AVG(DATEDIFF(SECOND, call.start_time, call.end_time)) FROM call)
                    ORDER BY calls DESC, country.id ASC;
                    """;

        String oldTextBlock =
                "SELECT\n" +
                "    country.country_name_eng,\n" +
                "    SUM(CASE WHEN call.id IS NOT NULL THEN 1 ELSE 0 END) AS calls,\n" +
                "    AVG(ISNULL(DATEDIFF(SECOND, call.start_time, call.end_time),0)) AS avg_difference\n" +
                "FROM country\n" +
                "LEFT JOIN city ON city.country_id = country.id\n" +
                "LEFT JOIN customer ON city.id = customer.city_id\n" +
                "LEFT JOIN call ON call.customer_id = customer.id\n" +
                "GROUP BY\n" +
                "    country.id,\n" +
                "    country.country_name_eng\n" +
                "HAVING AVG(ISNULL(DATEDIFF(SECOND, call.start_time, call.end_time),0)) > (SELECT AVG(DATEDIFF(SECOND, call.start_time, call.end_time)) FROM call)\n" +
                "ORDER BY calls DESC, country.id ASC;\n";

        // When
        boolean actual = oldTextBlock.equals(newTextBlockVersion);

        // Then
        assertThat(actual).isTrue();
    }

}