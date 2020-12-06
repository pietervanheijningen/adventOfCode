<?php
require __DIR__ . "/input.php";

$alphabet = "abcdefghijklmnopqrstuvwxyz";

$totalCount = 0;
foreach ($input as $answers) {
    foreach (str_split($alphabet) as $letter) {
        if (str_contains($answers, $letter)) {
            $totalCount++;
        }
    }
}

var_dump($totalCount);
