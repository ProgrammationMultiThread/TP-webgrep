/*
 * SPDX-License-Identifier: MIT
 * Author: Matthieu Perrin
 */

package webgrep;

import java.util.List;

/**
 * Represents the results of a parsed Web Page, including its matching expressions and hyperlinks.
 * @author Matthieu Perrin
 * @param url URL of the Web page
 * @param matches list of HTML elements (h1, h2, h3, h4, h5, p, dt and dd) containing a subexpression matching the regular expression
 * @param hrefs list of URLs references on the page
 */
public record ParsedPage(String url, List<String> matches, List<String> hrefs) {}

