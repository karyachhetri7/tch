#!/bin/bash
curl --location --request POST 'localhost:8080/content/search-requests/v1' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "searchCriteria": {
            "key": "CITY",
            "operation": "EQUAL",
            "value": "New York"
        },
        "condition": "OR"
    },
    {
        "searchCriteria": {
            "key": "STATE",
            "operation": "EQUAL",
            "value": "TX"
        }
    }
]'