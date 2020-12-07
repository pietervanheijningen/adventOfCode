<?php
require __DIR__ . "/input.php";
require __DIR__ . "/inputParser.php";

function findDirectParents($bagName)
{
    global $parsedRules;
    $parents = [];

    foreach ($parsedRules as $parsedRule) {
        foreach ($parsedRule['containedBags'] as $containedBag) {
            if ($containedBag['name'] == $bagName) {
                $parents[] = $parsedRule['bag'];
                break;
            }
        }
    }

    return $parents;
}

function findAllPossibleUpperParents($bag)
{
    $parents = findDirectParents($bag);

    $x = [];
    foreach ($parents as $parent) {
        $x[] = findAllPossibleUpperParents($parent);
    }

    return array_unique(array_merge($parents, ...$x));
}

var_dump(count(findAllPossibleUpperParents('shiny gold')));
