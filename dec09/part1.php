<?php
require __DIR__ . "/input.php";

$preamble = 25;
for ($i = $preamble; $i < count($input); $i++) {
    $subset = array_slice($input, $i - $preamble, $preamble);
    if (!isSumOfTwo($subset, $input[$i])) {
        var_dump($input[$i]);
        die();
    }
}

function isSumOfTwo($array, $number)
{
    foreach ($array as $nInArray1) {
        foreach ($array as $nInArray2) {
            if ($nInArray1 + $nInArray2 == $number) {
                return true;
            }
        }
    }
    return false;
}