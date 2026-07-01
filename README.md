# CineApp 🎬

App Android nativo em **Kotlin**, construído seguindo as práticas oficiais recomendadas pelo Google para apps modernos.

## Stack & Arquitetura

- **Jetpack Compose** (Compose-first, sem XML de UI)
- **Clean Architecture** em 3 camadas: `data` → `domain` → `presentation`
- **MVVM** com `StateFlow` (Unidirectional Data Flow)
- **Hilt** para injeção de dependência
- **Retrofit + OkHttp + Gson** para rede
- **Coroutines** para assincronismo
- **Navigation Compose** para navegação type-safe
- **Coil** para carregamento de imagens
- **Material 3** com tema customizado (paleta "cinema")
- **Version Catalog** (`libs.versions.toml`) para gestão de dependências

## Estrutura de pastas

```
app/src/main/java/com/movieapp/
├── data/
│   ├── remote/
│   │   ├── api/         → Retrofit service (TmdbApiService)
│   │   └── dto/         → Modelos brutos da API (DTOs)
│   └── repository/      → Implementação do repositório + mappers DTO→Domain
├── domain/
│   ├── model/            → Modelos de domínio puros (sem dependência de framework)
│   ├── repository/       → Interface (contrato) do repositório
│   └── usecase/          → Casos de uso (1 ação de negócio por classe)
├── presentation/
│   ├── components/       → Composables reutilizáveis (MovieCard, estados de loading/erro)
│   ├── navigation/       → NavGraph e rotas
│   ├── screen/
│   │   ├── home/          → HomeScreen + HomeViewModel + HomeUiState
│   │   └── detail/        → MovieDetailScreen + ViewModel + UiState
│   └── theme/             → Color, Type, Theme (Material 3)
└── di/                    → Módulos Hilt (Network, Repository)
```

## Como configurar

1. Crie uma conta gratuita em [themoviedb.org](https://www.themoviedb.org/) e gere uma **API Key (v3 auth)** em `Configurações → API`.
2. Abra `app/build.gradle.kts` e substitua:
   ```kotlin
   buildConfigField("String", "TMDB_API_KEY", "\"YOUR_TMDB_API_KEY_HERE\"")
   ```
   pela sua chave real.
3. Sincronize o Gradle e rode o app (`minSdk 24`, testado a partir do Android Studio Koala/Ladybug+).

## Funcionalidades

- Listagem de filmes por categoria (Populares, Mais Bem Avaliados, Em Cartaz, Em Breve)
- Busca de filmes com debounce (evita chamadas excessivas à API)
- Tela de detalhes: backdrop, sinopse, gênero, duração, elenco, produtoras
- Tratamento de erro/loading/empty state em todas as telas
- Splash screen nativa (`androidx.core.splashscreen`)
- Tema dark "cinema" com Material 3 dynamic-ready

## Próximos passos sugeridos

- Paginação infinita nas listas (já há suporte a `page` nos use cases/API)
- Cache local com Room para uso offline
- Testes unitários nos ViewModels e Use Cases (estrutura já desacoplada para isso)
- Favoritos persistidos localmente
