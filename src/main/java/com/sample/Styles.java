package com.sample;

import org.fluentness.style.Style;
import org.fluentness.style.StyleProducer;

public class Styles extends StyleProducer {

    Style milligram = css(
        select("*, *:after, *:before",
            box_sizing -> "inherit"
        ),

        select(".button, button, dd, dt, li",
            margin_bottom -> "1.0rem"
        ),

        select(".button, button, input[type='button'], input[type='reset'], input[type='submit']",
            background_color -> "#9b4dca",
            border -> "0.1remsolid#9b4dca",
            border_radius -> ".4rem",
            color -> "#fff",
            cursor -> "pointer",
            display -> "inline-block",
            font_size -> "1.1rem",
            font_weight -> "700",
            height -> "3.8rem",
            letter_spacing -> ".1rem",
            line_height -> "3.8rem",
            padding -> "03.0rem",
            text_align -> "center",
            text_decoration -> "none",
            text_transform -> "uppercase",
            white_space -> "nowrap"
        ),

        select(".button.button-clear, button.button-clear, input[type='button'].button-clear, input[type='reset'].button-clear, input[type='submit'].button-clear",
            background_color -> "transparent",
            border_color -> "transparent",
            color -> "#9b4dca"
        ),

        select(".button.button-clear:focus, .button.button-clear:hover, button.button-clear:focus, button.button-clear:hover, input[type='button'].button-clear:focus, input[type='button'].button-clear:hover, input[type='reset'].button-clear:focus, input[type='reset'].button-clear:hover, input[type='submit'].button-clear:focus, input[type='submit'].button-clear:hover",
            background_color -> "transparent",
            border_color -> "transparent",
            color -> "#606c76"
        ),

        select(".button.button-clear[disabled]:focus, .button.button-clear[disabled]:hover, button.button-clear[disabled]:focus, button.button-clear[disabled]:hover, input[type='button'].button-clear[disabled]:focus, input[type='button'].button-clear[disabled]:hover, input[type='reset'].button-clear[disabled]:focus, input[type='reset'].button-clear[disabled]:hover, input[type='submit'].button-clear[disabled]:focus, input[type='submit'].button-clear[disabled]:hover",
            color -> "#9b4dca"
        ),

        select(".button.button-outline, button.button-outline, input[type='button'].button-outline, input[type='reset'].button-outline, input[type='submit'].button-outline",
            background_color -> "transparent",
            color -> "#9b4dca"
        ),

        select(".button.button-outline:focus, .button.button-outline:hover, button.button-outline:focus, button.button-outline:hover, input[type='button'].button-outline:focus, input[type='button'].button-outline:hover, input[type='reset'].button-outline:focus, input[type='reset'].button-outline:hover, input[type='submit'].button-outline:focus, input[type='submit'].button-outline:hover",
            background_color -> "transparent",
            border_color -> "#606c76",
            color -> "#606c76"
        ),

        select(".button.button-outline[disabled]:focus, .button.button-outline[disabled]:hover, button.button-outline[disabled]:focus, button.button-outline[disabled]:hover, input[type='button'].button-outline[disabled]:focus, input[type='button'].button-outline[disabled]:hover, input[type='reset'].button-outline[disabled]:focus, input[type='reset'].button-outline[disabled]:hover, input[type='submit'].button-outline[disabled]:focus, input[type='submit'].button-outline[disabled]:hover",
            border_color -> "inherit",
            color -> "#9b4dca"
        ),

        select(".button:focus, .button:hover, button:focus, button:hover, input[type='button']:focus, input[type='button']:hover, input[type='reset']:focus, input[type='reset']:hover, input[type='submit']:focus, input[type='submit']:hover",
            background_color -> "#606c76",
            border_color -> "#606c76",
            color -> "#fff",
            outline -> "0"
        ),

        select(".button[disabled], button[disabled], input[type='button'][disabled], input[type='reset'][disabled], input[type='submit'][disabled]",
            cursor -> "default",
            opacity -> ".5"
        ),

        select(".button[disabled]:focus, .button[disabled]:hover, button[disabled]:focus, button[disabled]:hover, input[type='button'][disabled]:focus, input[type='button'][disabled]:hover, input[type='reset'][disabled]:focus, input[type='reset'][disabled]:hover, input[type='submit'][disabled]:focus, input[type='submit'][disabled]:hover",
            background_color -> "#9b4dca",
            border_color -> "#9b4dca"
        ),

        select(".clearfix:after",
            clear -> "both",
            content -> "''",
            display -> "table"
        ),

        select(".container",
            margin -> "0auto",
            max_width -> "112.0rem",
            padding -> "02.0rem",
            position -> "relative",
            width -> "100%"
        ),

        select(".float-left",
            FLOAT -> "left"
        ),

        select(".float-right",
            FLOAT -> "right"
        ),

        select(".label-inline",
            display -> "inline-block",
            font_weight -> "normal",
            margin_left -> ".5rem"
        ),

        select(".row",
            display -> "flex",
            flex_direction -> "column",
            padding -> "0",
            width -> "100%"
        ),

        select(".row .column",
            margin_bottom -> "inherit",
            padding -> "01.0rem"
        ),

        select(".row .column .column-bottom",
            align_self -> "flex-end"
        ),

        select(".row .column .column-center",
            _ms_grid_row_align -> "center",
            align_self -> "center"
        ),

        select(".row .column .column-top",
            align_self -> "flex-start"
        ),

        select(".row .column.column-10",
            flex -> "0010%",
            max_width -> "10%"
        ),

        select(".row .column.column-20",
            flex -> "0020%",
            max_width -> "20%"
        ),

        select(".row .column.column-25",
            flex -> "0025%",
            max_width -> "25%"
        ),

        select(".row .column.column-33, .row .column.column-34",
            flex -> "0033.3333%",
            max_width -> "33.3333%"
        ),

        select(".row .column.column-40",
            flex -> "0040%",
            max_width -> "40%"
        ),

        select(".row .column.column-50",
            flex -> "0050%",
            max_width -> "50%"
        ),

        select(".row .column.column-60",
            flex -> "0060%",
            max_width -> "60%"
        ),

        select(".row .column.column-66, .row .column.column-67",
            flex -> "0066.6666%",
            max_width -> "66.6666%"
        ),

        select(".row .column.column-75",
            flex -> "0075%",
            max_width -> "75%"
        ),

        select(".row .column.column-80",
            flex -> "0080%",
            max_width -> "80%"
        ),

        select(".row .column.column-90",
            flex -> "0090%",
            max_width -> "90%"
        ),

        select(".row .column.column-offset-10",
            margin_left -> "10%"
        ),

        select(".row .column.column-offset-20",
            margin_left -> "20%"
        ),

        select(".row .column.column-offset-25",
            margin_left -> "25%"
        ),

        select(".row .column.column-offset-33, .row .column.column-offset-34",
            margin_left -> "33.3333%"
        ),

        select(".row .column.column-offset-50",
            margin_left -> "50%"
        ),

        select(".row .column.column-offset-66, .row .column.column-offset-67",
            margin_left -> "66.6666%"
        ),

        select(".row .column.column-offset-75",
            margin_left -> "75%"
        ),

        select(".row .column.column-offset-80",
            margin_left -> "80%"
        ),

        select(".row .column.column-offset-90",
            margin_left -> "90%"
        ),

        select(".row.row-baseline",
            align_items -> "baseline"
        ),

        select(".row.row-bottom",
            align_items -> "flex-end"
        ),

        select(".row.row-center",
            align_items -> "center"
        ),

        select(".row.row-no-padding",
            padding -> "0"
        ),

        select(".row.row-no-padding > .column",
            padding -> "0"
        ),

        select(".row.row-stretch",
            align_items -> "stretch"
        ),

        select(".row.row-top",
            align_items -> "flex-start"
        ),

        select(".row.row-wrap",
            flex_wrap -> "wrap"
        ),

        select("a",
            color -> "#9b4dca",
            text_decoration -> "none"
        ),

        select("a:focus, a:hover",
            color -> "#606c76"
        ),

        select("b, strong",
            font_weight -> "bold"
        ),

        select("blockquote",
            border_left -> "0.3remsolid#d1d1d1",
            margin_left -> "0",
            margin_right -> "0",
            padding -> "1rem1.5rem"
        ),

        select("blockquote *:last-child",
            margin_bottom -> "0"
        ),

        select("blockquote, dl, figure, form, ol, p, pre, table, ul",
            margin_bottom -> "2.5rem"
        ),

        select("body",
            color -> "#606c76",
            font_family -> "'Roboto','HelveticaNeue','Helvetica','Arial',sans-serif",
            font_size -> "1.6em",
            font_weight -> "300",
            letter_spacing -> ".01em",
            line_height -> "1.6"
        ),

        select("code",
            background -> "#f4f5f6",
            border_radius -> ".4rem",
            font_size -> "86%",
            margin -> "0.2rem",
            padding -> ".2rem.5rem",
            white_space -> "nowrap"
        ),

        select("dl dl, dl ol, dl ul, ol dl, ol ol, ol ul, ul dl, ul ol, ul ul",
            font_size -> "90%",
            margin -> "1.5rem01.5rem3.0rem"
        ),

        select("dl, ol, ul",
            list_style -> "none",
            margin_top -> "0",
            padding_left -> "0"
        ),

        select("fieldset",
            border_width -> "0",
            padding -> "0"
        ),

        select("fieldset, input, select, textarea",
            margin_bottom -> "1.5rem"
        ),

        select("h1",
            font_size -> "4.6rem",
            line_height -> "1.2"
        ),

        select("h1, h2, h3, h4, h5, h6",
            font_weight -> "300",
            letter_spacing -> "-.1rem",
            margin_bottom -> "2.0rem",
            margin_top -> "0"
        ),

        select("h2",
            font_size -> "3.6rem",
            line_height -> "1.25"
        ),

        select("h3",
            font_size -> "2.8rem",
            line_height -> "1.3"
        ),

        select("h4",
            font_size -> "2.2rem",
            letter_spacing -> "-.08rem",
            line_height -> "1.35"
        ),

        select("h5",
            font_size -> "1.8rem",
            letter_spacing -> "-.05rem",
            line_height -> "1.5"
        ),

        select("h6",
            font_size -> "1.6rem",
            letter_spacing -> "0",
            line_height -> "1.4"
        ),

        select("hr",
            border -> "0",
            border_top -> "0.1remsolid#f4f5f6",
            margin -> "3.0rem0"
        ),

        select("html",
            box_sizing -> "border-box",
            font_size -> "62.5%"
        ),

        select("img",
            max_width -> "100%"
        ),

        select("input[type='checkbox'], input[type='radio']",
            display -> "inline"
        ),

        select("input[type='email'], input[type='number'], input[type='password'], input[type='search'], input[type='tel'], input[type='text'], input[type='url'], textarea, select",
            _webkit_appearance -> "none",
            _moz_appearance -> "none",
            appearance -> "none",
            background_color -> "transparent",
            border -> "0.1remsolid#d1d1d1",
            border_radius -> ".4rem",
            box_shadow -> "none",
            box_sizing -> "inherit",
            height -> "3.8rem",
            padding -> ".6rem1.0rem",
            width -> "100%"
        ),

        select("input[type='email']:focus, input[type='number']:focus, input[type='password']:focus, input[type='search']:focus, input[type='tel']:focus, input[type='text']:focus, input[type='url']:focus, textarea:focus, select:focus",
            border_color -> "#9b4dca",
            outline -> "0"
        ),

        select("label, legend",
            display -> "block",
            font_size -> "1.6rem",
            font_weight -> "700",
            margin_bottom -> ".5rem"
        ),

        select("ol",
            list_style -> "decimalinside"
        ),

        select("p",
            margin_top -> "0"
        ),

        select("pre",
            background -> "#f4f5f6",
            border_left -> "0.3remsolid#9b4dca",
            overflow_y -> "hidden"
        ),

        select("pre > code",
            border_radius -> "0",
            display -> "block",
            padding -> "1rem1.5rem",
            white_space -> "pre"
        ),

        select("select",
            background -> "url('data"
        ),

        select("select:focus",
            background_image -> "url('data"
        ),

        select("table",
            border_spacing -> "0",
            width -> "100%"
        ),

        select("td, th",
            border_bottom -> "0.1remsolid#e1e1e1",
            padding -> "1.2rem1.5rem",
            text_align -> "left"
        ),

        select("td:first-child, th:first-child",
            padding_left -> "0"
        ),

        select("td:last-child, th:last-child",
            padding_right -> "0"
        ),

        select("textarea",
            min_height -> "6.5rem"
        ),

        select("ul",
            list_style -> "circleinside"
        )
    );


    Style custom = css(
        select(".form-inline",
            display -> "flex",
            flex_flow -> "row wrap",
            align_items -> "center"
        ),

        select(".form-inline > input",
            width -> "auto"
        ),

        select(".form-inline > input:not(:first-child)",
            margin_left -> "5px"
        )
    );
}
