package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> createWinningRanks(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(winningLotto.createWinningRank(lotto));
        }
        return ranks;
    }

    public int getSize() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder lottoStringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            lottoStringBuilder.append(lotto);
            lottoStringBuilder.append("\n");
        }
        return lottoStringBuilder.toString();
    }
}