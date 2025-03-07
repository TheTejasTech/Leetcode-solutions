class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        std::vector<int> primeNumbers;
 
        for (int candidate = left; candidate <= right; candidate++) {
            if (candidate % 2 == 0 && candidate > 2) {
                continue;
            }
            if (isPrime(candidate)) { 
                if (!primeNumbers.empty() && candidate <= primeNumbers.back() + 2) {
                    return {primeNumbers.back(), candidate};
                }
                primeNumbers.push_back(candidate);
            }
        }
 
        if (primeNumbers.size() < 2) {
            return {-1, -1};
        }
 
        std::vector<int> closestPair = {-1, -1};
        int minDifference = INT_MAX;
        for (int i = 1; i < primeNumbers.size(); i++) {
            int difference = primeNumbers[i] - primeNumbers[i - 1];
            if (difference < minDifference) {
                minDifference = difference;
                closestPair = {primeNumbers[i - 1], primeNumbers[i]};
            }
        }

        return closestPair;
    }
    private:
    bool isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int divisor = 2; divisor <= (int)std::sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
};