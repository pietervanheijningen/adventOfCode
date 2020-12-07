<?php
require __DIR__ . "/input.php";
require __DIR__ . "/inputParser.php";

function findParentInfo($bagName)
{
    global $parsedRules;
    foreach ($parsedRules as $parsedRule) {
        if ($parsedRule["bag"] == $bagName) {
            return $parsedRule;
        }
    }

    return null;
}

function getTotalChildrenCount($bagName)
{
    $children = [];
    foreach (findParentInfo($bagName)['containedBags'] as $containedBag) {
        foreach (range(1, $containedBag['count']) as $b) {
            $children[] = $containedBag['name'];
        }
    }

    $count = 0;
    foreach ($children as $child) {
        $count += getTotalChildrenCount($child);
    }

    return count($children) + $count;
}


var_dump(getTotalChildrenCount('shiny gold'));
