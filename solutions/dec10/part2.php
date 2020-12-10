<?php
require __DIR__ . "/input.php";

function findNumberOfArrangements($input, $i = 0) {
    var_dump($input);
    $arrangementCount = 0;

    if (!isset($input[$i + 1])) {
        return 1;
    }

    $diff = $input[$i + 1] - $input[$i];
    var_dump($diff);
    if ($diff == 3) {
        findNumberOfArrangements($input, $i+1);
    } elseif ($diff == 2) {
        $index = array_search($input[$i] + 3, $input);
        if ($index !== false) {
            $arrangementCount += findNumberOfArrangements($input, $index);
        }
    } elseif ($diff == 1) {
        if (in_array($input[$i] + 3, $input)) {
            $index = array_search($input[$i] + 3, $input);
            if ($index !== false) {
                $arrangementCount += findNumberOfArrangements($input, $index);
            }
        }

        if (in_array($input[$i] + 2, $input)) {
            $index = array_search($input[$i] + 2, $input);
            if ($index !== false) {
                $arrangementCount += findNumberOfArrangements($input, $index);
            }
        }
    }

    return $arrangementCount;
}

$input = $inputtest2;

$input[] = 0;
$input[] = max($input) + 3;
sort($input);

var_dump(findNumberOfArrangements($input));
