#!/bin/bash
curl --location --request POST 'localhost:8080/content/bank-details/v1' \
--form 'file=@"../bank_details.csv"'