<?php
require __DIR__ . "/input.php";

$input[] = 0;
$input[] = max($input) + 3;
sort($input);

$oneCount = 0;
$threeCount = 0;
for ($i = 1; $i < count($input); $i++) {
    $diff = $input[$i] - $input[$i - 1];
    var_dump($diff);
    if ($diff == 1) {
        $oneCount++;
    } elseif ($diff == 3) {
        $threeCount++;
    }
}

var_dump($oneCount * $threeCount);