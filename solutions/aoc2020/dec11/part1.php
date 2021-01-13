<?php

require 'input.php';
$layout = $input;

function getNumberOfOccupiedAdjacentSeats($lineNr, $seatNr)
{
    global $originalLayout;
    $occupiedNr = 0;

    if (isset($originalLayout[$lineNr - 1][$seatNr - 1]) && $originalLayout[$lineNr - 1][$seatNr - 1] == '#')
        if ($seatNr != 0) $occupiedNr++;
    if (isset($originalLayout[$lineNr - 1][$seatNr]) && $originalLayout[$lineNr - 1][$seatNr] == '#') $occupiedNr++;
    if (isset($originalLayout[$lineNr - 1][$seatNr + 1]) && $originalLayout[$lineNr - 1][$seatNr + 1] == '#') $occupiedNr++;

    if (isset($originalLayout[$lineNr + 1][$seatNr - 1]) && $originalLayout[$lineNr + 1][$seatNr - 1] == '#')
        if ($seatNr != 0) $occupiedNr++;
    if (isset($originalLayout[$lineNr + 1][$seatNr]) && $originalLayout[$lineNr + 1][$seatNr] == '#') $occupiedNr++;
    if (isset($originalLayout[$lineNr + 1][$seatNr + 1]) && $originalLayout[$lineNr + 1][$seatNr + 1] == '#') $occupiedNr++;

    if (isset($originalLayout[$lineNr][$seatNr - 1]) && $originalLayout[$lineNr][$seatNr - 1] == '#')
        if ($seatNr != 0) $occupiedNr++;
    if (isset($originalLayout[$lineNr][$seatNr + 1]) && $originalLayout[$lineNr][$seatNr + 1] == '#') $occupiedNr++;

    return $occupiedNr;
}

$layout = str_replace('L', '#', $layout);

foreach (range(1,200) as $temp) {
    $originalLayout = $layout;

    for ($line = 0; $line < count($originalLayout); $line++) {
        for ($seat = 0; $seat < strlen($originalLayout[0]); $seat++) {
            if ($originalLayout[$line][$seat] == 'L') {
                if (getNumberOfOccupiedAdjacentSeats($line, $seat) == 0) {
                    $layout[$line][$seat] = '#';
                }
            } elseif ($originalLayout[$line][$seat] == '#') {
                if (getNumberOfOccupiedAdjacentSeats($line, $seat) >= 4) {
                    $layout[$line][$seat] = 'L';
                }
            }
        }
        echo "\n";
    }
}

// print layout
$occupiedCount = 0;
for ($line = 0; $line < count($layout); $line++) {
    for ($seat = 0; $seat < strlen($layout[0]); $seat++) {
        echo $layout[$line][$seat];
        if ($layout[$line][$seat] == '#') $occupiedCount++;
    }
    echo "\n";
}

var_dump($occupiedCount);