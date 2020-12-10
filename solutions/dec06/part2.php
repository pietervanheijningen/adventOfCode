<?php
require __DIR__ . "/input.php";

$alphabet = "abcdefghijklmnopqrstuvwxyz";

$totalCount = 0;
foreach ($input as $answers) {
    $perPerson = explode("\n", $answers);

    $personId = 0;
    $yesPerPerson = [];
    foreach ($perPerson as $personAnswer) {
        $yesPerPerson[$personId] = [];
        foreach (str_split($alphabet) as $letter) {
            if (str_contains($personAnswer, $letter)) {
                $yesPerPerson[$personId][] = $letter;
            }
        }

        $personId++;
    }

    $totalCount += count(array_intersect(...$yesPerPerson));

    $personId = 0;
}

var_dump($totalCount);
