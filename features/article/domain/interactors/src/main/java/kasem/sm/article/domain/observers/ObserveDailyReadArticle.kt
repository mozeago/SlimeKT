/*
 * Copyright (C) 2021, Kasem S.M
 * All rights reserved.
 */
package kasem.sm.article.domain.observers

import javax.inject.Inject
import kasem.sm.article.datasource.cache.ArticleDatabaseService
import kasem.sm.article.domain.interactors.toDomain
import kasem.sm.article.domain.model.Article
import kasem.sm.core.domain.ObserverInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ObserveDailyReadArticle @Inject constructor(
    private val cache: ArticleDatabaseService,
) : ObserverInteractor<Unit, Article?>() {
    override suspend fun execute(params: Unit): Flow<Article?> {
        return cache.getActiveArticleFlow().map {
            it?.toDomain()
        }
    }
}
