# Unlimited Shopping App

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/tuanfadbg/unlimitedshopping/
│   │   │   ├── di/                    # Dependency injection modules
│   │   │   ├── data/                  # Data layer
│   │   │   │   ├── api/              # API interfaces and models
│   │   │   │   ├── repository/       # Repository implementations
│   │   │   │   └── model/            # Data models
│   │   │   ├── domain/               # Domain layer
│   │   │   │   ├── model/            # Domain models
│   │   │   │   └── repository/       # Repository interfaces
│   │   │   ├── ui/                   # UI layer
│   │   │   │   ├── theme/            # Theme and styling
│   │   │   │   ├── navigation/       # Navigation components
│   │   │   │   ├── screens/          # Screen composables
│   │   │   │   └── components/       # Reusable UI components
│   │   │   └── utils/                # Utility classes
│   │   └── res/                      # Resources
│   └── test/                         # Test files
```

## Technology Stack

- **Architecture**: MVVM (Model-View-ViewModel)
- **UI**: Jetpack Compose
- **Navigation**: Jetpack Compose Navigation
- **Dependency Injection**: Dagger Hilt
- **Networking**: Retrofit
- **Coroutines**: For asynchronous operations

## Sample Screens

1. **Home Screen**: Displays featured products
2. **Product Detail Screen**: Shows detailed product information
3. **Cart Screen**: Displays items in the shopping cart

## Implementation Details

### Dependencies
- Dagger Hilt for dependency injection
- Retrofit for API calls
- Jetpack Compose for UI
- Navigation Compose for screen navigation
- Coroutines for asynchronous operations
- ViewModel for state management 


I’m starting with an empty project. Please structure the main folders and implement the code using these technologies: 
MVVM, Jetpack Compose, Retrofit, Dagger and Hilt for dependency injection, and Jetpack Compose Navigation, Coil3 Compose.

Additionally, include 3 sample screens with navigation between them.