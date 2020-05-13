/*
 * Copyright (c) 2020 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotx.features.widgets

import com.airbnb.mvrx.ActivityViewModelContext
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import im.vector.matrix.android.api.session.Session
import im.vector.riotx.core.platform.VectorViewModel

class RoomWidgetViewModel @AssistedInject constructor(@Assisted initialState: WidgetViewState,
                                                      private val session: Session)
    : VectorViewModel<WidgetViewState, RoomWidgetAction, RoomWidgetViewEvents>(initialState) {

    @AssistedInject.Factory
    interface Factory {
        fun create(initialState: WidgetViewState): RoomWidgetViewModel
    }

    companion object : MvRxViewModelFactory<RoomWidgetViewModel, WidgetViewState> {

        @JvmStatic
        override fun create(viewModelContext: ViewModelContext, state: WidgetViewState): RoomWidgetViewModel? {
            val factory = when (viewModelContext) {
                is FragmentViewModelContext -> viewModelContext.fragment as? Factory
                is ActivityViewModelContext -> viewModelContext.activity as? Factory
            }
            return factory?.create(state) ?: error("You should let your activity/fragment implements Factory interface")
        }
    }

    override fun handle(action: RoomWidgetAction) {
        //TODO
    }
}
