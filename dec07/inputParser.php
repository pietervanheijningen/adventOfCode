<?php

$parsedRules = [];
$i = 0;
foreach ($input as $rule) {
    preg_replace_callback(
        '/^(.*) bags contain (.*)./',
        function ($matches) {
            global $parsedRules;
            global $i;

            $containedBags = explode(', ', $matches[2]);
            $containedBagsArray = [];
            if (!str_contains("no other bags", $matches[2])) {
                foreach ($containedBags as $containedBag) {

                    $containedBagName = str_replace(' bag', '', str_replace(' bags', '', $containedBag));
                    $containedBagName = substr($containedBagName, 2);

                    $containedBagsArray[] = [
                        'count' => $containedBag[0],
                        'name' => $containedBagName
                    ];
                }
            }

            $parsedRules[$i] = [
                'bag' => $matches[1],
                'containedBags' => $containedBagsArray
            ];
            return;
        },
        $rule
    );
    $i++;
}